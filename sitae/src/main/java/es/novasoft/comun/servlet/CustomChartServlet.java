package es.novasoft.comun.servlet;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.eastwood.ChartEngine;
import org.jfree.eastwood.Parameters;

public class CustomChartServlet extends HttpServlet {
	private Font font;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		String fontSizeParam = config.getInitParameter("fontSize");
		String fontResourceParam = config.getInitParameter("fontResource");
		String fontFileParam = config.getInitParameter("fontFile");
		String fontParam = config.getInitParameter("font");

		float fontSize = 12.0F;
		if (fontSizeParam != null) {
			fontSize = Integer.parseInt(fontSizeParam);
		}

		if (fontResourceParam != null) {
			ServletContext ctx = config.getServletContext();
			font = readFontResource(ctx, fontResourceParam, fontSize);
		} else if (fontFileParam != null) {
			font = readFontFile(fontFileParam, fontSize);
		} else if (fontParam != null) {
			font = new Font(fontParam, 0, (int) fontSize);
		} else {
			font = new Font("Dialog", 0, (int) fontSize);
		}
	}

	private Font readFontResource(ServletContext ctx, String fontResourceParam, float fontSize) throws ServletException {
		if (!fontResourceParam.startsWith("/")) {
			fontResourceParam = "/" + fontResourceParam;
		}
		InputStream is = ctx.getResourceAsStream(fontResourceParam);
		if (is == null) {
			throw new ServletException("Font resource '" + fontResourceParam + "' not found");
		}
		try {
			return Font.createFont(0, is).deriveFont(fontSize);
		} catch (FontFormatException e) {
			throw new ServletException("Font resource '" + fontResourceParam + "' is not a truetype font", e);
		} catch (IOException e) {
			throw new ServletException("I/O error when reading font resource '" + fontResourceParam + "'", e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
	}

	private Font readFontFile(String fontFileParam, float fontSize) throws ServletException {
		File f = new File(fontFileParam);
		if (!f.exists()) {
			throw new ServletException("Font file '" + f + "' doesn't exist");
		}
		try {
			FileInputStream fis = new FileInputStream(f);
			Font font = Font.createFont(0, fis).deriveFont(fontSize);

			fis.close();
			return font;
		} catch (FontFormatException e) {
			throw new ServletException("Font file '" + f + "' is not a truetype font", e);
		} catch (IOException e) {
			throw new ServletException("I/O error when reading font file '" + f + "'", e);
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream out = response.getOutputStream();
		try {
			Map params = Parameters.parseQueryString(request.getQueryString());
			JFreeChart chart = ChartEngine.buildChart(params, font);

			if (chart != null) {
				response.setContentType("image/png");

				String[] size = (String[]) params.get("chs");
				int[] dims = new int[2];
				if (size != null) {
					dims = parseChartDimensions(size[0]);
				} else {
					dims = new int[] { 200, 125 };
				}

				ChartUtilities.writeChartAsPNG(out, chart, dims[0], dims[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	private int[] parseChartDimensions(String text) throws ServletException {
		if (text == null) {
			throw new IllegalArgumentException("Null 'text' argument (in parseChartDimensions(String)).");
		}

		int[] result = new int[2];
		int splitIndex = text.indexOf('x');
		String xStr = text.substring(0, splitIndex);
		String yStr = text.substring(splitIndex + 1);
		int x = Integer.parseInt(xStr);
		int y = Integer.parseInt(yStr);
		if ((x <= 1500) && (y <= 1500) && (x * y < 2250000)) {
			result[0] = x;
			result[1] = y;
		} else {
			throw new ServletException("Invalid chart dimensions: " + xStr + ", " + yStr);
		}

		return result;
	}
}