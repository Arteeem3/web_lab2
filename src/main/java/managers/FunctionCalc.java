package managers;

import data.Dot;

public class FunctionCalc {


   // final Logger logger = LoggerConfig.getLogger(FunctionCalc.class.getName());

    private boolean isTriangle(Dot dot) {
        return dot.getY() >= 0 && dot.getX() >= 0 && dot.getX() <= -2*dot.getY() + dot.getR();
    }


    private boolean isCircle(Dot dot) {
        if (dot.getX() >= 0 && dot.getY() <= 0 && dot.getX() <= dot.getR() && dot.getY() <= dot.getR())
            return (dot.getX() * dot.getX() + dot.getY() * dot.getY()) <= dot.getR() * dot.getR();
        return false;

    }


    private boolean isRectangle(Dot dot) {
        return dot.getX() <= 0 && dot.getY() <= 0 && dot.getX() >= -dot.getR() / 2 && dot.getY() >= -dot.getR();
    }

    public boolean isInTheSpot(Dot dot) throws Exception {
        if(dot != null) {
            if (!checkY(dot) || !checkR(dot) || !checkX(dot)) {
                return false;
            }
            if (isCircle(dot) || isTriangle(dot) || isRectangle(dot)) {
                //logger.info("Returned true");
                return true;
            }

            //logger.warning("Returned false : x=%d, y=%f, r=%d".formatted(dot.getX(), dot.getY(), dot.getR()));
            return false;
        }
        throw new Exception("Invalid JSON data");
    }


    private boolean checkY(Dot dot) throws Exception {
        if (dot.getY() <= 5 && dot.getY() >= -5) {
            return true;
        }

        throw new Exception("Invalid value");
    }

    private boolean checkR(Dot dot) throws Exception {
        if(dot.getR() >=1 && dot.getR() <=5){
            return true;
        }
        System.out.println("something wrong with r");
        throw new Exception("Invalid value");
    }


    private boolean checkX(Dot dot) throws Exception {
        if(dot.getX() >= -4 && dot.getX() <= 4) {
            return true;
        }
        throw new Exception("Invalid value");

    }


}