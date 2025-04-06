package com.example.socialnetwork.action;

import com.example.socialnetwork.form.LoginForm;
import com.example.socialnetwork.dao.UserDAO;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            request.setAttribute("error", "Tên đăng nhập và mật khẩu không được để trống!");
            return mapping.findForward("failure");
        }

        UserDAO userDAO = new UserDAO();
        boolean isValid = userDAO.checkLogin(username, password);
        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            return mapping.findForward("success");
        } else {
            request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return mapping.findForward("failure");
        }
    }
}
