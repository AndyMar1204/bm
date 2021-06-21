package com.andy.bana_mboka.forms;

import eu.medsea.mimeutil.MimeUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ir Andy
 */
public class Outils {

    public static void uploader(HttpServletRequest req, HttpServletResponse resp, String typeOfFile, int maxFile, String... fileName) throws FormException {
        String file_name = null;

        boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
        if (!isMultipartContent) {
            throw new FormException("Formulaire ne prends pas en charge les fichiers");
        }
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {

            List< FileItem> fields = upload.parseRequest(req);
            Iterator< FileItem> it = fields.iterator();
            if (!it.hasNext()) {
                throw new FormException("Aucun fichier à uploader");
            }
            if (fields.size() != maxFile) {
                throw new FormException("Nombres des fichiers uploadés est differents au nombre de fichiers demandé");
            }
            for (String s : fileName) {

            }
            while (it.hasNext()) {
                FileItem fileItem = it.next();
                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    if (file_name == null) {
                        if (fileItem.getFieldName().equals("file_name")) {
                            file_name = fileItem.getString();

                        }
                    }
                } else {
                    if (fileItem.getSize() > 0) {
                        File f = new File(fileItem.getName());
                        String extension = MimeUtil.getExtension(f);
                        File file = new File("D:\\upload\\" + fileItem.getName());
                        fileItem.write(file);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void fileRenammer(File file, String newName) {
        String extension = MimeUtil.getExtension(file);
        String path = "D:\\uploads\\";
        String name = newName.concat(extension);
        if (file.renameTo(new File(path.concat(name)))) {
            System.out.println("Success...");
        } else {
            System.out.println("Failed...");
        }
    }

    public static void fileUploader(HttpServletRequest req, HttpServletResponse resp, String fileNam) throws FormException, Exception {
        String file_name = null;
        PrintWriter out = resp.getWriter();
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
        if (!isMultipartContent) {
            return;
        }FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            
            List< FileItem> fields = upload.parseRequest(req);
            Iterator< FileItem> it = fields.iterator();
            if (!it.hasNext()) {
                return;
            }
            while (it.hasNext()) {
                FileItem fileItem = it.next();
                boolean isFormField = fileItem.isFormField();
                if (isFormField) {
                    if (file_name == null) {
                        if (fileItem.getFieldName().equals(fileNam)) {
                            file_name = fileItem.getString();
                            
                        }
                    }
                } else {
                    if (fileItem.getSize() > 0) {
                        
                        
                        fileItem.write(new File("D:\\upload\\" + fileItem.getName()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        
        }
    }

}
