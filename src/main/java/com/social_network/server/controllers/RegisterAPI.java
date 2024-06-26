package com.social_network.server.controllers;

import com.social_network.server.HibernateUtil;
import com.social_network.server.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "register-api", value = "/api/user/register")
public class RegisterAPI extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try (session) {
            transaction.begin();
            HashMap<String, String> parameters = this.getUserRegisterParameters(request);

            User user = new User(parameters.get("username"), parameters.get("password"));
            session.persist(user);
            if (!transaction.getStatus().equals(TransactionStatus.ACTIVE)) {
                transaction.rollback();
                throw new Exception();
            }
            transaction.commit();
            StringBuilder responseBuilder = new StringBuilder();
            responseBuilder.append("{")
                    .append("\"id\": \"").append(user.getId()).append("\", ")
                    .append("\"username\": \"").append(user.getUsername()).append("\"")
                    .append("}");

            String responseMessage = this.getResponseMessage(responseBuilder.toString());
            response.setStatus(201);
            response.getOutputStream().println(responseMessage);
            response.setContentType("application/json");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            response.setStatus(401);
            response.setContentType("application/json");
            response.getOutputStream().println("__error__: Error registering user");
            transaction.rollback();
            throw new RuntimeException(e);
        } catch (Exception e) {
            response.setStatus(401);
            response.setContentType("application/json");
            response.getOutputStream().println("__error__: Error registering user");
            transaction.rollback();
            e.printStackTrace();
        }
    }

    private HashMap<String, String> getUserRegisterParameters(HttpServletRequest request) throws IOException {
        StringBuilder jsonDataBuilder = new StringBuilder();
        String line;
        while ((line = request.getReader().readLine()) != null) {
            jsonDataBuilder.append(line);
        }
        String jsonData = jsonDataBuilder.toString();
        JSONObject jsonObject = new JSONObject(jsonData);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("username", username);
        parameters.put("password", password);
        return parameters;
    }

    private String getResponseMessage(String message) {
        JSONObject responseObject = new JSONObject();
        responseObject.put("message", message);
        return responseObject.toString();
    }
}
