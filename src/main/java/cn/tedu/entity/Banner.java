package cn.tedu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Banner {
    private int id;
    private String title;
    private String url;

    public Banner(int id, String url) {
        this.id = id;
        this.url = url;
    }

}
