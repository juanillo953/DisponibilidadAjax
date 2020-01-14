<%@page import="Controlador.Bd"%>
<%@page contentType="text/XML" pageEncoding="UTF-8"%>
<%
    boolean encontrado = false;
    String nombre = request.getParameter("nombre");
    Bd bd = new Bd();
    bd.abrirConexion();
    String[]usuarios= bd.encuentraUsuarios();
    for(int contador=0;contador<usuarios.length;contador++){
        if(nombre.equals(usuarios[contador])){
            encontrado=true;
            out.println("<disponibilidad><disponible>no</disponible><alternativas><login>123"+nombre+"</login>"
                    + "<login>"+nombre+"otro</login><login>"+nombre+"a</login><login>"+nombre+"100</login></alternativas></disponibilidad>");
        }
    }
    if(!encontrado){
      out.println("<disponibilidad><disponible>si</disponible></disponibilidad>");
    }
%>