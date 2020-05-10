package fastcampus.datastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 해시테이블Test {
    private 해시테이블.OpenHashTable openHashing = new 해시테이블.OpenHashTable();
    private 해시테이블.CloseHashTable closeHashTable = new 해시테이블.CloseHashTable();

    @Test
    public void 값을_저장하고_읽는다_OpenHashTable() {
        openHashing.save("a key", "a value");
        openHashing.save("b key", "b value");
        openHashing.save("c key", "c value");

        assertThat(openHashing.read("a key").get()).isEqualTo("a value");
        assertThat(openHashing.read("b key").get()).isEqualTo("b value");
        assertThat(openHashing.read("c key").get()).isEqualTo("c value");
    }

    @Test
    public void hash_address가_같아도_저장된다_OpenHashTable() {
        openHashing.save("test key1", "test value1");
        openHashing.save("test key2", "test value2");
        openHashing.save("test key3", "test value3");

        assertThat(openHashing.read("test key1").get()).isEqualTo("test value1");
        assertThat(openHashing.read("test key2").get()).isEqualTo("test value2");
        assertThat(openHashing.read("test key3").get()).isEqualTo("test value3");
    }

    @Test
    public void 같은_키에_대해_값을_바꿀_수_있다_OpenHashTable() {
        openHashing.save("test key1", "test value1");
        openHashing.save("test key1", "test value2");

        assertThat(openHashing.read("test key1").get()).isEqualTo("test value2");
    }

    @Test
    public void 값을_저장하고_읽는다_CloseHashTable() {
        closeHashTable.save("a key", "a value");
        closeHashTable.save("b key", "b value");
        closeHashTable.save("c key", "c value");

        assertThat(closeHashTable.read("a key").get()).isEqualTo("a value");
        assertThat(closeHashTable.read("b key").get()).isEqualTo("b value");
        assertThat(closeHashTable.read("c key").get()).isEqualTo("c value");
    }

    @Test
    public void hash_address가_같아도_저장된다_CloseHashTable() {
        closeHashTable.save("a key1", "a value1");
        closeHashTable.save("a key2", "a value2");
        closeHashTable.save("a key3", "a value3");

        assertThat(closeHashTable.read("a key1").get()).isEqualTo("a value1");
        assertThat(closeHashTable.read("a key2").get()).isEqualTo("a value2");
        assertThat(closeHashTable.read("a key3").get()).isEqualTo("a value3");

        closeHashTable.save("b key1", "b value1");
        closeHashTable.save("b key2", "b value2");
        closeHashTable.save("b key3", "b value3");

        assertThat(closeHashTable.read("b key1").get()).isEqualTo("b value1");
        assertThat(closeHashTable.read("b key2").get()).isEqualTo("b value2");
        assertThat(closeHashTable.read("b key3").get()).isEqualTo("b value3");
    }

    @Test
    public void 같은_키에_대해_값을_바꿀_수_있다_CloseHashTable() {
        closeHashTable.save("test key1", "test value1");
        closeHashTable.save("test key1", "test value2");

        assertThat(closeHashTable.read("test key1").get()).isEqualTo("test value2");
    }
}
