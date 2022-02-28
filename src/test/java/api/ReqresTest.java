package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";


    @Test
    @DisplayName("Гет метод убедиться , что имена файлов-автоаров пользователей совпадают, коночание емэйл рекрес.ин")
    public void chekAvatarAndIdTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());



//        List<UserData> users = given()
//                .when()
//                .contentType(ContentType.JSON)                 Пример запроса без спецификации
//                .get(URL + "api/users?page=2")
//                .then().log().all()
//                .extract().body().jsonPath().getList("data" , UserData.class);

        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data" , UserData.class);




        users.forEach(x-> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assertions.assertTrue(users.stream().allMatch(x-> x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());

        List<String> emailsUsersList = users.stream().map(UserData::getEmail).collect(Collectors.toList());
        List<String> emails2 = users.stream().map(x -> x.getEmail()).collect(Collectors.toList());


        for (int i=0; i < avatars.size(); i++){
            Assertions.assertTrue(avatars.get(i).contains(ids.get(i)));

        }

        for (int i=0; i < emailsUsersList.size() ; i++){
            Assertions.assertTrue(emailsUsersList.get(i).contains(emails2.get(i)));
        }

    }

    @Test
    @DisplayName("Пост запрос на успешную регистрацию, с использованием спецификации")
    public void seccessRegTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");

        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assertions.assertNotNull(successReg.getId());
        Assertions.assertNotNull(successReg.getToken());
        Assertions.assertEquals(id, successReg.getId());
        Assertions.assertEquals(token, successReg.getToken());

    }
    @Test
    @DisplayName("Пост запрос на неуспешную регистрацию, с использованием спецификации")
    public void unseccessRegTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError400());
        Register user = new Register("eve.holt@reqres.in", "");

        UnSuccessReg unSuccessReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);

        Assertions.assertEquals("Missing password", unSuccessReg.getError());
    }

    @Test
    @DisplayName("Гет запрос , получаем ответ в годах и проверить что сортировка работает")
    public void sortedYearsTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<ColorsData> colors = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data" , ColorsData.class);
        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(sortedYears, years);
        System.out.println(years);
        System.out.println(sortedYears);
    }

    @Test
    @DisplayName("Проверить , что статус метода Делет 204")
    public void deleteUserTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();


    }

    @Test
    @DisplayName("Обновить инфу о пользователе и сравнить дату обновления с текущей датой на машине")
    public void timeTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        UserTime user = new UserTime("morpheus", "zion president");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);

            String regex = "(.{5})$";
            String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");
            Assertions.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex, ""));
    }



}
