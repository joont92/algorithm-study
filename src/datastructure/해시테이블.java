package datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * - 기존의 저장공간을 확장해서 사용하는 Open Hashing 기법(Chaining 기법)
 * - 해시테이블 address 의 value 로 LinkedList 를 가진다
 * - address 가 충돌할 경우 value 에 있는 LinkedList 에 key : value 를 저장한다
 */
public class 해시테이블 {
    static class OpenHashTable {
        private List<LinkedList<KeyValue>> tables;

        public OpenHashTable() {
            tables = Stream.generate((Supplier<LinkedList<KeyValue>>) LinkedList::new)
                .limit(20)
                .collect(Collectors.toList());
        }

        private int hashFunction(String key) {
            return key.charAt(0) % 20;
        }

        public void save(String key, String value) {
            int address = hashFunction(key);

            LinkedList<KeyValue> elements = tables.get(address);
            for (KeyValue element : elements) {
                if (element.isKeyEquals(key)) {
                    element.setValue(value);
                    return;
                }
            }

            elements.add(new KeyValue(key, value));
        }

        public Optional<String> read(String key) {
            int address = hashFunction(key);

            LinkedList<KeyValue> elements = tables.get(address);
            for (KeyValue element : elements) {
                if (element.isKeyEquals(key)) {
                    return Optional.of(element.getValue());
                }
            }

            return Optional.empty();
        }
    }

    static class CloseHashTable {
        private List<KeyValue> tables;

        public CloseHashTable() {
            tables = Stream.generate(KeyValue::empty)
                .limit(20)
                .collect(Collectors.toList());
        }

        private int hashFunction(String key) {
            return key.charAt(0) % 20;
        }

        public void save(String key, String value) {
            int address = hashFunction(key);

            for (int i = address; i < 20; i++) {
                if(tables.get(address).isEmpty()) {
                    tables.set(address, new KeyValue(key, value));
                    break;
                }

                tables.get(address).setValue(value);
            }
        }

        public Optional<String> read(String key) {
            int address = hashFunction(key);

            for (int i = address; i < 20; i++) {
                if (!tables.get(address).isEmpty()) {
                    return Optional.of(tables.get(address).getValue());
                }
            }

            return Optional.empty();
        }
    }

    static class KeyValue {
        private String key;
        private String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public static KeyValue empty() {
            return new KeyValue(null, null);
        }

        public boolean isEmpty() {
            return key == null && value == null;
        }

        public boolean isKeyEquals(String key) {
            return this.key.equals(key);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
