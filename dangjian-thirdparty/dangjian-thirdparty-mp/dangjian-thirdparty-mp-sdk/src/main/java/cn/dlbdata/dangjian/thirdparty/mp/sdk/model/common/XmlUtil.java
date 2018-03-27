package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XmlUtil {

//	private static XStream stream = new XStream();

    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * 将xml转换为map
     *
     * @param document
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseWxXml(Document document)
            throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        Element root = document.getRootElement();
        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    /**
     * xml转化为对象
     *
     * @param bojXml
     * @param objName
     * @param clzz
     * @return
     */
    public static <T> T toObject(String bojXml, String objName, Class<T> clzz) {
        xstream.alias(objName, clzz);
        @SuppressWarnings("unchecked")
        T xmlobj = (T) xstream.fromXML(bojXml);
        return xmlobj;
    }

    /**
     * 对象转化为xml
     *
     * @param map
     * @param obj
     * @return
     */
    public static <T> String toXml(Map<String, Class<?>> map, T obj) {
        if (map == null) {
            String objxml = xstream.toXML(obj);
            return objxml;
        }
        Set<String> set = map.keySet();
        for (String str : set) {
            xstream.alias(str, map.get(str));
        }
        String objxml = xstream.toXML(obj);
        return objxml;
    }

}

