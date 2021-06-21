package com.andy.bana_mboka.forms;

import com.andy.bana_mboka.model.Fichier;
import eu.medsea.mimeutil.MimeUtil;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ir Andy
 */
public class FichierForm {

    private static final String LOCATION = "/Users/admin/NetBeansProjects/bana_mboka/src/main/webapp/uploads/";

    public Fichier fichierUploader(HttpServletRequest req, String nameFile) throws FormException {
        String file_name = null;
        Fichier fichier = null;
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
        if (!isMultipartContent) {
            throw new FormException("Le formulaire ne prends pas en charge les fichiers");
        } else {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List< FileItem> fields;
            try {
                fields = upload.parseRequest(req);
                Iterator< FileItem> it = fields.iterator();
                if (!it.hasNext()) {
                    throw new FormException("Aucun fichier telecharger");
                } else {
                    while (it.hasNext()) {
                        FileItem fileItem = it.next();
                        boolean isFormField = fileItem.isFormField();
                        if (isFormField) {
                            if (file_name == null) {
                                if (fileItem.getFieldName().equals("")) {
                                    file_name = fileItem.getString();
                                }
                            }
                        } else {
                            if (fileItem.getSize() > 0) {
                                File file = new File(LOCATION + fileItem.getName());

                                try {
                                    fileItem.write(file);
                                    if (nameFile != null) {
                                        if(file.exists()){
                                            String extension = MimeUtil.getExtension(file);
                                            File file2 = new File(LOCATION.concat(nameFile)+".".concat(extension));
                                            file.renameTo(file2);
                                            fichier = fileToFichier(file2);
                                        }
                                    }

                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                    throw new FormException("Echec lors de l'ecriture du fichier sur le serveur");
                                }
                            }
                        }
                    }
                }
            } catch (FileUploadException ex) {
                ex.printStackTrace();
                throw new FormException("Erreur survenu sur le serveur lors du telechargement");
            }

        return fichier;    
        }

    }

    private Fichier fileToFichier(File file) {
        if (file.exists()) {
            Fichier fichier = new Fichier();
            fichier.setNom(file.getName());
            fichier.setDateCreation(LocalDateTime.now());
            return fichier;
        } else {
            return null;
        }
    }

    private File fileRenammer(File file, String file_name) {
        String extension = MimeUtil.getExtension(file);

        String chemin = LOCATION;
        File fil = new File(chemin + file_name.concat(timeGetter()) + "." + extension);
        if (file.renameTo(fil)) {

            return fil;
        } else
            return null;
    }

    public static String timeGetter() {
        LocalDateTime dt = LocalDateTime.now();
        String year = String.valueOf(dt.getYear());
        String month = String.valueOf(dt.getMonthValue());
        String day = String.valueOf(dt.getDayOfMonth());
        String hour = String.valueOf(dt.getHour());
        String min = String.valueOf(dt.getMinute());
        String sec = String.valueOf(dt.getSecond());
        String time = year.concat("-").concat(month).concat("-").concat(day).concat(":").concat(hour).concat("-").concat(min).concat("-").concat(sec).concat("bm");
        return time;
    }
}
