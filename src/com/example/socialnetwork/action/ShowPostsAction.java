package com.example.socialnetwork.action;

import com.example.socialnetwork.dao.UserDAO;
import com.example.socialnetwork.dao.PostDAO;
import com.example.socialnetwork.model.Post; // Sử dụng lớp Post từ package model
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowPostsAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            request.setAttribute("error", "Vui lòng đăng nhập!");
            return mapping.findForward("login");
        }

        UserDAO userDAO = new UserDAO();
        int userId = userDAO.getUserId(username);
        if (userId == -1) {
            request.setAttribute("error", "Người dùng không tồn tại!");
            return mapping.findForward("failure");
        }

        PostDAO postDAO = new PostDAO();
        List<Post> posts = postDAO.getPostsByUserId(userId);
        request.setAttribute("posts", posts);
        return mapping.findForward("success");
    }
}