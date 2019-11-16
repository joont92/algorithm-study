package datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 해시테이블Test {
    private 해시테이블.OpenHashTable openHashing = new 해시테이블.OpenHashTable();
    private 해시테이블.CloseHashTable closeHashTable = new 해시테이블.CloseHashTable();

    @Test
    public void 값을_저장하고_읽는다_OpenHashTable() {
        openHashing.save("test key", "test value");

        assertThat(openHashing.read("test key").get()).isEqualTo("test value");
    }

    @Test
    public void hash_address가_같아도_저장된다_OpenHashTable() {
        openHashing.save("test key1", "test value");
        openHashing.save("test key2", "test value");
        openHashing.save("test key3", "test value");

        assertThat(openHashing.read("test key1").get()).isEqualTo("test value");
        assertThat(openHashing.read("test key2").get()).isEqualTo("test value");
        assertThat(openHashing.read("test key3").get()).isEqualTo("test value");
    }

    @Test
    public void 값을_저장하고_읽는다_CloseHashTable() {
        closeHashTable.save("test key", "test value");

        assertThat(closeHashTable.read("test key").get()).isEqualTo("test value");
    }

    @Test
    public void hash_address가_같아도_저장된다_CloseHashTable() {
        closeHashTable.save("test key1", "test value");
        closeHashTable.save("test key2", "test value");
        closeHashTable.save("test key3", "test value");

        assertThat(closeHashTable.read("test key1").get()).isEqualTo("test value");
        assertThat(closeHashTable.read("test key2").get()).isEqualTo("test value");
        assertThat(closeHashTable.read("test key3").get()).isEqualTo("test value");
    }
}
