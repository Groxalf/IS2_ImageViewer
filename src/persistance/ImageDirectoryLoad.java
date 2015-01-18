package persistance;

import model.Image;
import model.ProxyImage;
import model.RealImage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ImageDirectoryLoad implements ImageListLoader{

    private final String directoryPath;

    public ImageDirectoryLoad(String directoyPath) {
        this.directoryPath = directoyPath;
    }


    @Override
    public List<Image> load() {
        return linkImages(createImagesForPaths(findIamgeOnDirectory(new File(directoryPath))));
    }


    private List<String> findIamgeOnDirectory(File mainDirectory) {
        List<String> extensions = Arrays.asList(".jpg", ".png");
        List<String> results = new ArrayList<>();
        for (String extension : extensions) {
            results.addAll(Arrays.asList(findFilesWithExtension(mainDirectory, extension)));
        }
        return results;
    }


    private String[] findFilesWithExtension(File file, String extension) {
        return file.list((dir, name) -> name.contains(extension));
    }


    private List<Image> createImagesForPaths(List<String> allImagePath) {
        List<Image> result = new ArrayList<Image>();
        for (String path : allImagePath) {
            result.add(new ProxyImage(new BufferedImageLoader(directoryPath + "\\" +  path)));
        }
        return result;
    }


    private List<Image> linkImages(List<Image> images) {
        return linkPrevImages(linkNextImages(images));
    }


    private List<Image> linkPrevImages(List<Image> images){
        for (int i = 0; i < images.size(); i++) 
            images.get(i).
                    setPrev(images.get((i + images.size() - 1) % images.size()));
        return images;
    }


    private List<Image> linkNextImages(List<Image> images){
        for (int i = 0; i < images.size(); i++) 
            images.get(i).
                    setNext(images.get((i + 1) % images.size()));
        return images;
    }

}
