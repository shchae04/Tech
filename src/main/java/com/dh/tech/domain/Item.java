package com.dh.tech.domain;

import lombok.Data;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _ this.quantity >= 10000", message = "������ ������ �Ѿ�� �Է����ּ���.")
public class Item {

    private Long id;
    private String itemName;
    private Integer price;

    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

