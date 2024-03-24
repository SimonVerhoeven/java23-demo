package dev.simonverhoeven.java23demo.preview;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {

    GarderobeSelectionInput handle(String userId) throws ExecutionException, InterruptedException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            Future<Person> personFuture = executorService.submit(() -> findPerson(userId));
            Future<Weather> weatherFuture = executorService.submit(this::fetchWeather);
            Future<Activity> activityFuture = executorService.submit(() -> findActivity(userId));
            Person person = personFuture.get();   // Join findPerson
            Weather weather = weatherFuture.get(); // Join fetchWeather
            Activity activity = activityFuture.get(); // Join findActivity
            return new GarderobeSelectionInput(person, weather, activity);
        }
    }

    Person findPerson(String id) throws InterruptedException {
        Thread.sleep(2000L);
        return null;}
    Weather fetchWeather() throws InterruptedException {
        Thread.sleep(5000L);
        return null;}
    Activity findActivity(String id) throws InterruptedException {
        Thread.sleep(3000L);
        return null;
    }

    class Person {}
    class Weather {}
    class Activity {}
    public record GarderobeSelectionInput(Person person, Weather weather, Activity activity){}
}
