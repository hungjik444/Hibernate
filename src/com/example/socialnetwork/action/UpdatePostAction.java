package com.example.socialnetwork.action;

import com.example.socialnetwork.form.PostForm;
import com.example.socialnetwork.dao.UserDAO;
import com.example.socialnetwork.dao.PostDAO;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdatePostAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            request.setAttribute("error", "Vui lòng đăng nhập!");
            return mapping.findForward("login");
        }

        PostForm postForm = (PostForm) form;
        String postId = postForm.getId();
        String title = postForm.getTitle();
        String body = postForm.getBody();

        if (postId == null || postId.trim().isEmpty() || title == null || title.trim().isEmpty() || body == null || body.trim().isEmpty()) {
            request.setAttribute("error", "Dữ liệu không hợp lệ!");
            return mapping.findForward("failure");
        }

        UserDAO userDAO = new UserDAO();
        int userId = userDAO.getUserId(username);
        if (userId == -1) {
            request.setAttribute("error", "Người dùng không tồn tại!");
            return mapping.findForward("failure");
        }

        PostDAO postDAO = new PostDAO();
        boolean updated = postDAO.updatePost(Integer.parseInt(postId), title, body, userId);
        if (!updated) {
            request.setAttribute("error", "Không thể cập nhật bài viết!");
            return mapping.findForward("failure");
        }

        return mapping.findForward("success");
    }
}