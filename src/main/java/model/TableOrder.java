package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TableOrder {
    String code;
    String Description;
    int Qty;
    Double Price;
    Double Total;

    @Override
    public boolean equals(Object o) {
        TableOrder order = (TableOrder) o;
        if (this.code == order.getCode() ) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, Description, Qty, Price, Total);
    }
}
