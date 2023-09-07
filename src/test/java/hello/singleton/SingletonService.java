package hello.singleton;

public class SingletonService {

  private static final SingletonService instance = new SingletonService();

  public static SingletonService getInstance() {
    return instance;
  }

  //private 생성자를 만들어서 다른 곳에서 객체를 생성하지 못하게 막음. 오직 getInstance()를 통해서 호출만 가능.
  private SingletonService(){}

  public void logic() {
    System.out.println("싱글톤 객체 로직 호출");
  }
}
