package br.com.eleomardorneles.android.cardview.model;

public class Post {
    private String name;
    private String postText;
    private int image;

    public Post() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Post(String name, String postText, int image) {
        this.name = name;
        this.postText = postText;
        this.image = image;
    }
}
