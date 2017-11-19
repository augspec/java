/**
 * 
 */
package com.aug.annotations.handleruntime;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.aug.annotations.HtmlTag;

/**
 * Xử lý cho @HtmlTag trong thời gian chạy
 * 
 * @author AUG
 *
 */
public class HtmlTagHandleRuntime {
	
	private final String[] htmlTags = new String[] {"a", "abbr", "address", "area", "article", 
			"aside", "audio", "b", "base", "bdi", "bdo", "big", "blockqoute", "body", "br", 
			"button", "canvas", "caption", "center", "cite", "code", "col", "colgroup", "datalist", 
			"dd", "del", "details", "dfn", "dialog", "dir", "div", "dl", "dt", "em", "embed", "fieldset", 
			"figcaption", "figure", "font", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", 
			"h5", "h6", "head", "header", "hr", "html", "i", "iframe", "img", "input", "ins", "kbd", "label", 
			"legend", "li", "link", "main", "mark", "map", "menu", "menuitem", "meta", "meter", "nav", "noframes", 
			"noscript", "object", "ol", "optgroup", "option", "output", "p", "param", "picture", "pre", "progress", 
			"q", "rp", "rt", "ruby", "s", "samp", "script", "section", "small", "source", "span", "strike", "strong", 
			"style", "sub", "summary", "sup", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "time", "title", 
			"tr", "track", "tt", "u", "ul", "var", "vidio", "wbr"};

	public void processing(Object obj) throws Exception {
		
		if (obj == null)
			return;
		
		List<String> listHtmlTags = new ArrayList<String>();
		for (String tag : htmlTags) {
			listHtmlTags.add(tag);
		}
		
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		
		String className = clazz.getSimpleName();
		StringBuilder sb = new StringBuilder();
		sb.append("<meta charset=\"UTF-8\">");
		sb.append("<center>");
		sb.append("<h1>" + className + "</h1>");
		
		for (Field field : fields) {
			field.setAccessible(true);
			
			if (field.isAnnotationPresent(HtmlTag.class)) {
				HtmlTag annotation = field.getAnnotation(HtmlTag.class);
				
				String tagName = annotation.tagName().toLowerCase();
				if (!listHtmlTags.contains(tagName)) {
					throw new Exception("tagName không phải là một tag trong Html");
				}
				
				String style = annotation.style();
				String href = annotation.href();
				String target = annotation.target();
				
				sb.append("<" + tagName + (style != "" ? " style=\"" + style + "\"" : "") 
						+ (tagName.equals("a") ? ((href != "" ? " href=\"" + href + "\"" : "") + (target != "" ? "target=\"" + target + "\"" : "")) : "") + ">");
				sb.append(field.get(obj));
				sb.append("</" + tagName + ">");
			}
		}
		
		sb.append("</center>");
		
		saveFile(sb.toString());
	}
	
	public void saveFile(final String content) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				JFileChooser jfc = new JFileChooser();
				jfc.showSaveDialog(null);
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(jfc.getSelectedFile());
					fw.write(content);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (fw != null) {
						try {
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	public static void main(String[] args) {
		HtmlTagHandleRuntime handle = new HtmlTagHandleRuntime();
		handle.saveFile("");
	}
}
