package com.papsukis.CardSimulator.Decklist.services.Impl;

import com.papsukis.CardSimulator.Decklist.services.ImageService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;

@Service
public class ImageServiceImpl implements ImageService {

    String baseUrl = "C:/CardSimulator/images/";
    String localHost = "http://localhost:10000/images/";

    @Override
    public String storeImg(String IMGurl, String name) throws IOException {
        URL url = new URL(IMGurl);

        File f=new File(baseUrl+name+".jpg");
        if(!f.exists()) {
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();
            FileOutputStream fos = new FileOutputStream(baseUrl + name + ".jpg");
            fos.write(response);
            fos.close();
        }

        return localHost+name+".jpg";
    }
}
