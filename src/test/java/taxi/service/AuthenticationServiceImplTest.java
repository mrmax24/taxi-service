package taxi.service;

import taxi.exception.AuthenticationException;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taxi.model.Manufacturer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceImplTest {
    private Driver driver;
    private Manufacturer manufacturer;
    private Car car;
    private static final Injector injector = Injector.getInstance("taxi");
    private final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);
    private final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);
    private final CarService carService = (CarService) injector
            .getInstance(CarService.class);

    @BeforeEach
    void setUp() {
            driver = new Driver();
            driver.setName("Bob");
            driver.setLicenseNumber("45382");
            driver.setLogin("bob");
            driver.setPassword("1234");
            driverService.create(driver);

            manufacturer = new Manufacturer();
            manufacturer.setName("Mazda");
            manufacturer.setCountry("Japan");
            manufacturerService.create(manufacturer);

            car = new Car();
            car.setDrivers(List.of());
            car.setModel("6");
            car.setManufacturer(manufacturer);
            carService.create(car);
    }
    @Test
    void registerValidUser_Ok () {
        Driver actual = driverService.create(driver);
        assertEquals(actual, driver, "Your registration was failed");
    }

    @Test
    void loginIsNull_notOk() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login(null, "1234");
        });
    }

    @Test
    void loginIsIncorrect_notOk() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("dave@9821", "1234");
        });
    }

    @Test
    void passwordIsNull_notOk() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("bob", null);
        });
    }

    @Test
    void passwordIsIncorrect_notOk() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("bob", "123456");
        });
    }

    @Test
    void getValidUser_Ok () {
        Driver actual = driverService.get(driver.getId());
        assertEquals(actual, driver);
    }

    @Test
    void getValidCar_Ok () {
        Car actual = carService.get(car.getId());
        assertEquals(actual, car);
    }

    @Test
    void getValidManufacturer_Ok () {
        Manufacturer actual = manufacturerService.get(car.getManufacturer().getId());
        assertEquals(actual, manufacturer);
    }
}
