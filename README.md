# RulEST
A drools rule engine RESTful Web Services.The purpose is let user can use drools rule engine by resuful web service.

## Requirement
* Java JDK 1.7
* Gradle

## Build and Run

Get source code
```
$ git clone https://github.com/eternnoir/RulEST.git
$ cd RulEst
```

Build and test
```
$ ./gradlew build 
$ ./gradlew test
```

Run
```
$ ./gradlew run
```

## Test Sample Rule

The rule is 
```
package drools
import org.enoir.rulest.sample.SampleFact

rule "Hello World"
    when
        m : SampleFact( status == 1, myMessage : message )
    then
        System.out.println( myMessage );
        m.setMessage( "Goodbye world" );
        m.setStatus( 0 );
        update( m );
end

rule "GoodBye"
    when
        SampleFact( status == 0, myMessage : message )
    then
        System.out.println( myMessage );
end
```

***POST*** Josn to http://127.0.0.1:8080/execute
```json
{
   "targetRulePackage":"SampleRP",
   "Facts":[
      {
         "id": 1,
         "message":"Hello RulEST",
         "status":1
      }
   ]
}
```

Server will return
```json
[
   {
      "id":1,
      "message":"Goodbye world",
      "status":0
   }
]
```

Console output:
```
2015-04-20 14:06:15.601  INFO 17534 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
2015-04-20 14:06:15.615  INFO 17534 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 14 ms
2015-04-20 14:06:17.473  INFO 17534 --- [nio-8080-exec-1] org.reflections.Reflections              : Reflections took 1812 ms to scan 63 urls, producing 4818 keys and 23463 values 
Hello RulEST
Goodbye world
```

Multiple facts:
```json
{
   "targetRulePackage":"SampleRP",
   "Facts":[
      {
         "id":1,
         "message":"Hello RulEST",
         "status":1
      },
      {
         "id":2,
         "message":"Hello RulEST2",
         "status":1
      },
      {
         "id":3,
         "message":"Hello RulEST3",
         "status":1
      }
   ]
}
```

Result:
```json
[
   {
      "id":2,
      "message":"Goodbye world",
      "status":0
   },
   {
      "id":1,
      "message":"Goodbye world",
      "status":0
   },
   {
      "id":3,
      "message":"Goodbye world",
      "status":0
   }
]
```

Console output:
```
Hello RulEST3
Hello RulEST2
Hello RulEST
Goodbye world
Goodbye world
Goodbye world
```

## TODO

* Pluginable RulePackage.
* Support Drools stream mode.
 

