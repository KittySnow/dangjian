package cn.dlbdata.dangjian.common.util;

import org.apache.commons.lang.ObjectUtils;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static cn.dlbdata.dangjian.common.util.StringUtil.lineToHump;


public class MybatisGeneratorUtil {

	/**
	 * generatorConfig模板路径
 	 */
	private static String generatorConfig_vm = "/template/generatorConfig.vm";
	/**
	 * Service模板路径
	 */
	private static String service_vm = "/template/Service.vm";
	/**
	 * ServiceMock模板路径
	 */
	private static String serviceMock_vm = "/template/ServiceMock.vm";
	/**
	 * ServiceImpl模板路径
	 */
	private static String serviceImpl_vm = "/template/ServiceImpl.vm";

	private static String controller_vm = "/template/Controller.vm";

	private static String list_vm = "/template/List.vm";

	private static String add_vm = "/template/Add.vm";

	private static String edit_vm = "/template/Edit.vm";

	/**
	 * 根据模板生成generatorConfig.xml文件
	 * @param jdbc_driver   驱动路径
	 * @param jdbc_url      链接
	 * @param jdbc_username 帐号
	 * @param jdbc_password 密码
	 * @param module        项目模块
	 * @param database      数据库
	 * @param schema        视图
	 * @param table_prefix  表前缀
	 * @param package_name  包名
	 */
	public static void generator(
			String jdbc_driver,
			String jdbc_url,
			String jdbc_username,
			String jdbc_password,
			String module,
			String database,
			String schema,
			String table_prefix,
			String package_name,
			Map<String, String> last_insert_id_tables,
			Map<String, String> HTML_FILE_NAME,
			Map<String, String> FILE_CH_NAME
			) throws Exception{

		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath().replaceFirst("/", "");
			service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath().replaceFirst("/", "");
			serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath().replaceFirst("/", "");
			serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath().replaceFirst("/", "");
		} else {
			generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath();
			service_vm = MybatisGeneratorUtil.class.getResource(service_vm).getPath();
			serviceMock_vm = MybatisGeneratorUtil.class.getResource(serviceMock_vm).getPath();
			serviceImpl_vm = MybatisGeneratorUtil.class.getResource(serviceImpl_vm).getPath();
		}

		String targetProject = module + "/" + module + "-dao";
		String basePath = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "").replace(targetProject, "").replaceFirst("/", "");
		String generatorConfig_xml = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "") + "/src/main/resources/generatorConfig.xml";
		targetProject = basePath + targetProject;
		String sql = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + schema + "' AND table_name LIKE '" + table_prefix + "_%';";


		System.out.println(sql);
		System.out.println("========== 开始生成generatorConfig.xml文件 ==========");
		List<Map<String, Object>> tables = new ArrayList();
		try {
			VelocityContext context = new VelocityContext();
			Map<String, Object> table;

			// 查询定制前缀项目的所有表
			JdbcUtil jdbcUtil = new JdbcUtil(jdbc_driver, jdbc_url, jdbc_username, PBEUtil.decrypt(jdbc_password));
			List<Map> result = jdbcUtil.selectByParams(sql, null);
			for (Map map : result) {
				System.out.println(map.get("table_name"));
				System.out.println(lineToHump(ObjectUtils.toString(map.get("table_name"))));
				table = new HashMap();
				table.put("table_name", map.get("table_name"));
				table.put("model_name", lineToHump(ObjectUtils.toString(map.get("table_name"))));
				tables.add(table);
			}
			jdbcUtil.release();

			String targetProject_sqlMap = basePath + module + "/" + module + "-rpc-service";
			context.put("schema", schema);
			context.put("tables", tables);
			context.put("generator_javaModelGenerator_targetPackage", package_name + ".model");
			context.put("generator_sqlMapGenerator_targetPackage", package_name + ".dao");
			context.put("generator_javaClientGenerator_targetPackage", package_name + ".dao");
			context.put("targetProject", targetProject);
			context.put("targetProject_sqlMap", targetProject_sqlMap);
			context.put("generator_jdbc_password", PBEUtil.decrypt(jdbc_password));
			context.put("last_insert_id_tables", last_insert_id_tables);


			System.out.println(generatorConfig_xml);
			VelocityUtil.generate(generatorConfig_vm, generatorConfig_xml, context);
			System.out.println(context);
			// 删除旧代码
			deleteDir(new File(targetProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/model"));
			deleteDir(new File(targetProject + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao"));
			deleteDir(new File(targetProject_sqlMap + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/dao"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("========== 结束生成generatorConfig.xml文件 ==========");

		System.out.println("========== 开始运行MybatisGenerator ==========");
		List<String> warnings = new ArrayList();
		File configFile = new File(generatorConfig_xml);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String warning : warnings) {
			System.out.println(warning);
		}
		System.out.println("========== 结束运行MybatisGenerator ==========");

		System.out.println("========== 开始生成Service ==========");
		String ctime = new SimpleDateFormat("yyyy/M/d").format(new Date());
		String servicePath = basePath + module + "/" + module + "-rpc-api" + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/service";
		String serviceImplPath = basePath + module + "/" + module + "-rpc-api" + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/service/impl";
		String controllerPath = basePath + module + "/" + module + "-rpc-api" + "/src/main/java/" + package_name.replaceAll("\\.", "/") + "/controller";

		String ListHtmlPath = basePath + module + "/" + module + "-rpc-api" + "/web/";



		for (int i = 0; i < tables.size(); i++) {

			String tableName = ObjectUtils.toString(tables.get(i).get("table_name"));

			String model = lineToHump(tableName);
			String service = servicePath + "/" + model + "Service.java";
			String serviceMock = servicePath + "/" + model + "ServiceMock.java";
			String serviceImpl = serviceImplPath + "/" + model + "ServiceImpl.java";
			String controllerV = controllerPath + "/" + model + "Controller.java";

			if(null != HTML_FILE_NAME.get(tableName) ){

				// 生成service
				File serviceFile = new File(service);
				if (!serviceFile.exists()) {
					VelocityContext context = new VelocityContext();
					context.put("package_name", package_name);
					context.put("model", model);
					context.put("ctime", ctime);
					context.put("mapper", StringUtil.toLowerCaseFirstOne(model));
					context.put("smallMapper",tableName);
					context.put("last_insert_id_tables", last_insert_id_tables);
					context.put("smallKey", last_insert_id_tables.get(tableName).toLowerCase());
					VelocityUtil.generate(service_vm, service, context);
					System.out.println(service);
				}

				// 生成serviceImpl
				File serviceImplFile = new File(serviceImpl);
				if (!serviceImplFile.exists()) {
					VelocityContext context = new VelocityContext();
					context.put("package_name", package_name);
					context.put("model", model);
					context.put("mapper", StringUtil.toLowerCaseFirstOne(model));
					context.put("smallMapper", tableName);
					context.put("ctime", ctime);
					context.put("last_insert_id_tables", last_insert_id_tables);
					context.put("smallKey", last_insert_id_tables.get(tableName).toLowerCase());
					VelocityUtil.generate(serviceImpl_vm, serviceImpl, context);
					System.out.println(serviceImpl);
				}

				// 生成controller
				File serviceImplFile12 = new File(controllerV);
				if (!serviceImplFile12.exists()) {
					VelocityContext context = new VelocityContext();
					context.put("package_name", package_name);
					context.put("model", model);
					context.put("mapperLowerCase", StringUtil.toLowerCaseFirstOne(model).toLowerCase());
					context.put("mapper", StringUtil.toLowerCaseFirstOne(model));
					context.put("ctime", ctime);
					context.put("smallMapper", tableName);
					context.put("last_insert_id_tables", last_insert_id_tables);
					context.put("smallKey", last_insert_id_tables.get(tableName).toLowerCase());
					VelocityUtil.generate(controller_vm, controllerV, context);
					System.out.println(controllerV);
				}

				ListHtmlPath += HTML_FILE_NAME.get(tableName)+"/";
				File file_date = new File(ListHtmlPath);
				if(file_date.exists()){

				}else{
					file_date.mkdirs();
				}

				String listHtml = ListHtmlPath+StringUtil.toLowerCaseFirstOne(HTML_FILE_NAME.get(tableName))+".html";
				String addHtml = ListHtmlPath+"add"+model.replaceFirst("P","")+".html";
				String editHtml = ListHtmlPath+"edit"+model.replaceFirst("P","")+".html";


				String mapper = StringUtil.toLowerCaseFirstOne(model);

				JdbcUtil jdbcUtil = new JdbcUtil(jdbc_driver, jdbc_url, jdbc_username, PBEUtil.decrypt(jdbc_password));



				String sql2 = "SELECT col_description(a.attrelid,a.attnum) as comment,a.attname as name  FROM pg_class as c,pg_attribute as a where c.relname = '"+tableName+"' and a.attrelid = c.oid and a.attnum>0";

				List<Map> resultComment2 = jdbcUtil.selectByParams(sql2, null);



				String mykey = last_insert_id_tables.get(tableName).toLowerCase();
				List<RenderColumn> renderList = new ArrayList<RenderColumn>() ;


				for (int j = 0; j < resultComment2.size(); j++) {
					RenderColumn c = new RenderColumn();
					Map t = resultComment2.get(j);
					String cname =StringUtil.getString(t.get("name"));
					System.out.println(cname);
					c.setAlias(StringUtil.getString(t.get("comment")));
					c.setKeys(cname);
					if(!mykey.equals(cname)){
						renderList.add(c);
					}
				}




				String fileNameLowerCaseFirstOne = StringUtil.toLowerCaseFirstOne(HTML_FILE_NAME.get(tableName));
				String chinaName = FILE_CH_NAME.get(tableName);

				//生成列表页
				File listHtmlFile = new File(listHtml);
				if (!listHtmlFile.exists()) {
					VelocityContext context = new VelocityContext();
					context.put("package_name", package_name);
					context.put("model", model);
					context.put("mapper", mapper);
					context.put("mapperLowerCase", mapper.toLowerCase());
					context.put("mapperLowerCaseFirstOne", StringUtil.toLowerCaseFirstOne(mapper));
					context.put("ctime", ctime);
					context.put("smallMapper", tableName);
					context.put("smallName", mapper.replaceFirst("p",""));
					context.put("last_insert_id_tables", last_insert_id_tables);
					context.put("key", mykey);
					context.put("renderList",renderList);
					context.put("html_file_name", HTML_FILE_NAME);
					context.put("fileNameLowerCaseFirstOne", fileNameLowerCaseFirstOne);
					context.put("chinaName",chinaName);
					VelocityUtil.generate(list_vm, listHtml, context);
					System.out.println(listHtmlFile);
				}

				//生成增加页
				File addHtmlFile = new File(addHtml);
				if (!addHtmlFile.exists()) {
					VelocityContext context = new VelocityContext();
					context.put("package_name", package_name);
					context.put("model", model);
					context.put("mapper", mapper);
					context.put("mapperLowerCase", mapper.toLowerCase());
					context.put("mapperLowerCaseFirstOne", StringUtil.toLowerCaseFirstOne(mapper));
					context.put("ctime", ctime);
					context.put("smallMapper", tableName);
					context.put("smallName", mapper.replaceFirst("p",""));
					context.put("last_insert_id_tables", last_insert_id_tables);
					context.put("key", mykey);
					context.put("renderList",renderList);
					context.put("html_file_name", HTML_FILE_NAME);
					context.put("fileNameLowerCaseFirstOne", fileNameLowerCaseFirstOne);
					context.put("chinaName",chinaName);
					VelocityUtil.generate(add_vm, addHtml, context);
					System.out.println(addHtmlFile);
				}

				//生成修改
				File editHtmlFile = new File(editHtml);
				if (!editHtmlFile.exists()) {
					VelocityContext context = new VelocityContext();
					context.put("package_name", package_name);
					context.put("model", model);
					context.put("mapper", mapper);
					context.put("mapperLowerCase", mapper.toLowerCase());
					context.put("mapperLowerCaseFirstOne", StringUtil.toLowerCaseFirstOne(mapper));
					context.put("ctime", ctime);
					context.put("smallMapper", tableName);
					context.put("smallName", mapper.replaceFirst("p",""));
					context.put("smallNameLowerCase", mapper.replaceFirst("p","").toLowerCase());
					context.put("last_insert_id_tables", last_insert_id_tables);
					context.put("key", mykey);
					context.put("renderList",renderList);
					context.put("html_file_name", HTML_FILE_NAME);
					context.put("fileNameLowerCaseFirstOne", fileNameLowerCaseFirstOne);
					context.put("chinaName",chinaName);
					VelocityUtil.generate(edit_vm, editHtml, context);
					System.out.println(editHtmlFile);
				}
			}

		}
		System.out.println("========== 结束生成Service ==========");
	}

	// 递归删除非空文件夹
	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteDir(files[i]);
			}
		}
		dir.delete();
	}
	
	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://180.169.82.28:7125/jlyzparty";
		String jdbc_username = "root";
		String jdbc_password = "root";
		String module = "";
		String database = "";
		String schema = "";
		String table_prefix = "";
		String package_name = "cn.dlbdata.dangjian.admin.dao";
		Map<String, String> last_insert_id_tables = new HashMap<>();
		Map<String, String> HTML_FILE_NAME = new HashMap<>();
		Map<String, String> FILE_CH_NAME = new HashMap<>();
		try {
			generator(jdbc_driver, jdbc_url, jdbc_username, jdbc_password, module, database, schema, table_prefix, package_name, last_insert_id_tables, HTML_FILE_NAME, FILE_CH_NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
