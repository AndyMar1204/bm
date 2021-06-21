<%-- 
    Document   : uploader
    Created on : 31 mai 2021, 14:43:12
    Author     : Ir Andy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <form method = "post" action = "uploader" encType = "multipart/form-data">
        <input type = "file" name = "file_name" value = "select images ..." accept="image/*" multiple=false/>
        <input type = "submit" value = "start upload" />
    </form>
</div>
        
