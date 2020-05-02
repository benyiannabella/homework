public interface Operations<T extends Number> {

    T add(T num1, T num2);
    T divide(T num1, T num2) throws DivisionByZeroException;
    T multiply(T num1, T num2);
    T substract(T num1, T num2);
    T verifySign(char sign, Number num1, Number num2);
}
