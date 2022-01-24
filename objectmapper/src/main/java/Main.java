import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("k3");
        car1.setCarNumber("5134");
        car1.setType("세단");

        Car car2 = new Car();
        car2.setName("k35");
        car2.setCarNumber("5134ㅈ");
        car2.setType("세단ㅈ");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        System.out.println(user);

        String json = objectMapper.writeValueAsString(user);

        System.out.println(json);

        // json 파싱  - json ->  java로 key를 찾아 값을 가져온다
        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        //cars 배열의 노드(json안에 Array - List)
        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() { });

        System.out.println(_cars);

        // json 키로 값을 변경경
       ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "steve");
        objectNode.put("age", 20);

        System.out.println(objectNode.toPrettyString());
    }
}
