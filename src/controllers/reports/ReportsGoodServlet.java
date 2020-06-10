package controllers.reports;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Good;
import models.GoodLogic;

/**
 * Servlet implementation class ReportsGoodServlet
 */
@WebServlet("/reports/good")
public class ReportsGoodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsGoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 初回起動を判定するための処理
        // アプリケーションスコープから値を取得
        ServletContext sc = this.getServletContext();
        Good g = (Good)sc.getAttribute("good");

        //初回起動判定の続き
        // アプリケーションスコープに値がなければnewする
        if(g == null) {
            g = new Good();
            sc.setAttribute("good", g);
        }

        // リクエストパラメータの取得
        String good = request.getParameter("action");

        // いいね！が押されたら
        if(good != null) {
            // GoodLogicでいいねを加算
            GoodLogic gl = new GoodLogic();
            gl.goodPlus(g);

            // いいねの数をアプリケーションスコープに保存
            sc.setAttribute("good",g);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/show.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
