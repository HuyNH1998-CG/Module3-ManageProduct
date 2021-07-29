package Controller;

import Model.Product;
import Service.ProductStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {""})
public class Controller extends HttpServlet {
    private ProductStorage productStorage = new ProductStorage();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> showCreateForm(request, response);
            case "edit" -> showEditForm(request, response);
            case "delete" -> showDeleteForm(request, response);
            case "view" -> viewProduct(request,response);
            default -> listProducts(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> createProduct(request, response);
            case "edit" -> updateProduct(request, response);
            case "delete" -> deleteProduct(request, response);
            case "search" -> searchProduct(request,response);
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.productStorage.findAll();
        request.setAttribute("product", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/landing.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String picture = request.getParameter("picture");
        float price = Float.parseFloat(request.getParameter("price"));
        Product product = new Product(id, name, picture, price);
        this.productStorage.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
        request.setAttribute("message", "New customer was created");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = this.productStorage.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/view/notfound.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/view/edit.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String picture = request.getParameter("picture");
        float price = Float.parseFloat(request.getParameter("price"));
        Product product = this.productStorage.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/view/notfound.jsp");
        } else {
            product.setName(name);
            product.setPicture(picture);
            product.setPrice(price);
            this.productStorage.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Customer info was updated");
            dispatcher = request.getRequestDispatcher("/view/edit.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = this.productStorage.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/view/notfound.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("/view/delete.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Product product = this.productStorage.findByID(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("/view/notfound.jsp");
            dispatcher.forward(request, response);
        } else {
            this.productStorage.remove(id);
            response.sendRedirect("/");
        }
    }
    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = this.productStorage.findByID(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("/view/notfound.jsp");
        } else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("/view/view.jsp");
        }
        dispatcher.forward(request,response);
    }
    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> products = new ArrayList<>();
        for(Product p : this.productStorage.findAll()){
            if(p.getName().equals(name)){
                products.add(p);
            }
        }
        request.setAttribute("product", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/landing.jsp");
        dispatcher.forward(request, response);
    }
}
