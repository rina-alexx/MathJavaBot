package org.example;

public class Task {
    public String numbVariant;
    public String arguments;

    public long chatId;

    public Task() {
    }

    public String getNumbVariant() {
        return numbVariant;
    }

    public void setNumbVariant(String numbVariant) {
        this.numbVariant = numbVariant;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
    public String askAnswer() {
        int j=Integer.parseInt(numbVariant);
        double res = 0;
        String mas[]=arguments.split(" ");

        switch (j) {
            case (1):
                double a = Double.parseDouble(mas[0]);
                double x = Double.parseDouble(mas[1]);
                double b = Double.parseDouble(mas[2]);
                double n = Double.parseDouble(mas[3]);
                double c = Double.parseDouble(mas[4]);
                res = ((5 * Math.pow(a, n * x)) / (b + c)) - Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3))));
                //  System.out.println(res);

                break;
            case (2):
                double y = Double.parseDouble(mas[0]);
                x = Double.parseDouble(mas[1]);
                double gam = Double.parseDouble(mas[2]);
                a = Double.parseDouble(mas[3]);
                res = ((Math.abs(x - y)) / (Math.pow(1 + 2 * x, a))) - Math.pow(Math.E, Math.sqrt(1 + gam));
                //System.out.println(res)
                break;
            case (3):
                double a0 = Double.parseDouble(mas[0]);
                double a1 = Double.parseDouble(mas[1]);
                double a2 = Double.parseDouble(mas[2]);
                x = Double.parseDouble(mas[3]);
                res = Math.sqrt(a0 + a1 * x + a2 * Math.cbrt(Math.abs(Math.sin(x))));
                // System.out.println( res);

                break;
            case (4):
                a = Double.parseDouble(mas[0]);
                x = Double.parseDouble(mas[1]);
                res = Math.log(Math.abs(Math.pow(a, 7))) + Math.atan(x * x) + (Math.PI / Math.sqrt(Math.abs(a + x)));
                // System.out.println(res);

                break;
            case (5):
                a = Double.parseDouble(mas[0]);
                x = Double.parseDouble(mas[1]);
                b = Double.parseDouble(mas[2]);
                double d = Double.parseDouble(mas[3]);
                c = Double.parseDouble(mas[4]);
                res = (Math.pow(((Math.pow(a + b, 2)) / (c + d)) + Math.pow(Math.E, Math.sqrt(x + 1)), 0.2));
                // System.out.println( res);

                break;
            case (6):
                x = Double.parseDouble(mas[0]);
                res = (Math.pow(Math.E, (2 * Math.sqrt(4 * x) + Math.pow(Math.cos(x * x), 2)) / 3 * x));
                // System.out.println(res);

                break;
            case (7):
                x = Double.parseDouble(mas[0]);
                res = (0.25 * (((1 + x * x) / (1 - x)) + 0.5 * Math.tan(x)));
                // System.out.println(res);
                break;
        }
        String result=String.valueOf(res);
        return result;

    }
}
