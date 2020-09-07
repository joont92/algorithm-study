package fastcampus.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. hash 함수에 key 를 넣어 address 를 구한다
 * 2. address 에서 List<KeyValue>를 구한 뒤, key 가 같은 객체를 반환한다
 */
public class 해시테이블 {
    private static final int DEFAULT_TABLE_SIZE = 20;
    /**
     * Open Hashing 기법(Chaining 기법)
     * - 기존의 저장공간을 확장해서 사용함
     * - 해시테이블 address 의 value 로 LinkedList 를 가진다
     * - address 가 충돌할 경우 value 에 있는 LinkedList 에 key : value 를 저장한다
     */
    static class OpenHashTable {
        private List<LinkedList<KeyValue>> tables;

        public OpenHashTable() {
            tables = Stream.generate((Supplier<LinkedList<KeyValue>>) LinkedList::new)
                .limit(DEFAULT_TABLE_SIZE)
                .collect(Collectors.toList());
        }

        private int hashFunction(String key) {
            return key.charAt(0) % DEFAULT_TABLE_SIZE;
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

    /**
     * Closing Hashing(Linear Probing 기법)
     * - 기존의 저장공간 외의 공간을 활용하는 기법
     * - address 가 충돌할 경우 다음 address 로 이동해서 값을 저장한다
     */
    static class CloseHashTable {
        private int tableSize = DEFAULT_TABLE_SIZE * 2;
        private List<KeyValue> tables;

        public CloseHashTable() {
            tables = Stream.generate(KeyValue::empty)
                .limit(tableSize)
                .collect(Collectors.toList());
        }

        private int hashFunction(String key) {
            return key.charAt(0) % DEFAULT_TABLE_SIZE;
        }

        public void save(String key, String value) {
            int address = hashFunction(key);

            for (int i = address; i < tableSize; i++) {
                KeyValue keyValue = tables.get(i);
                if(keyValue.isEmpty() || keyValue.isKeyEquals(key)) {
                    tables.set(i, new KeyValue(key, value));
                    break;
                }
            }
        }

        public Optional<String> read(String key) {
            int address = hashFunction(key);

            for (int i = address; i < tableSize; i++) {
                KeyValue keyValue = tables.get(i);
                if (keyValue.isKeyEquals(key)) {
                    return Optional.of(keyValue.getValue());
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
