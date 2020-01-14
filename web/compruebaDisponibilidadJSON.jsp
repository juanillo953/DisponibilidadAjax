<%-- 
    Document   : compruebaDisponibilidadJSON
    Created on : 09-ene-2020, 11:35:32
    Author     : Alumno_2DAW
--%>

<%@page import="Controlador.Bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean encontrado = false;
    String nombre = request.getParameter("nombre");
    Bd bd = new Bd();
    bd.abrirConexion();
    String[]usuarios= bd.encuentraUsuarios();
    for(int contador=0;contador<usuarios.length;contador++){
        if(nombre.equals(usuarios[contador])){
            out.println("{disponible:'no', alternativas: ['123"+nombre+"','"+nombre+"otro','"+nombre+"','"+nombre+"100']}");
            encontrado=true;
        }
    }
    if(!encontrado){
      out.println("{disponible:'si'}");
    }
%>