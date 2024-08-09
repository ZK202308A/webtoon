package org.example.anno;

@WebPath("/todo")
public class TodoController {

    @Controller("/list")
    public void list(){
        System.out.println("list");
    }

    @Controller("/add")
    public void register(){
        System.out.println("register");
    }

    @Controller("/remove")
    public void delete(){
        System.out.println("delete");
    }
}
