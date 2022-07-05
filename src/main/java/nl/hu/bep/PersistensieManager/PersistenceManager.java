package nl.hu.bep.PersistensieManager;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.bep.PersistensieManager.AppManager;

import java.io.*;

public class PersistenceManager {
    private final static String ENDPOINT = "https://bep7ilias.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2024-05-01T16:08:02Z&st=2022-07-01T08:08:02Z&spr=https&sig=q8Wc%2FsPKS9W8i8KoXbR5iM7WIYm2eHgdviuPob%2F%2Fzj0%3D";
    private final static String CONTAINER = "battlesnake-final";

    private static BlobContainerClient blobContainer= new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();


    public static void loadFrom() {
        try {
            if(blobContainer.exists()) {
                BlobClient blob = blobContainer.getBlobClient("battlesnake-final");

                if(blob.exists()){
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    blob.download(baos);

                    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                    ObjectInputStream ois = new ObjectInputStream(bais);
                    AppManager loadedAppManaer = (AppManager) ois.readObject();
                    AppManager.setAppManager(loadedAppManaer);
                }
            } else {
                System.out.println("Er is geen blob");
            }
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    public static void saveAppToAzure() throws IOException {
        if (!blobContainer.exists()) {
            blobContainer.create();
        }
        BlobClient blob = blobContainer.getBlobClient("battlesnake-final");
        AppManager AppManagerToSave = AppManager.getAppManager();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(AppManagerToSave);

        byte[] bytez = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blob.upload(bais, bytez.length, true);

        bais.close();
        baos.close();

    }

}
