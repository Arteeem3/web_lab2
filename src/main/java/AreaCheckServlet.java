import com.google.gson.Gson;
import data.Dot;
import managers.FunctionCalc;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {

    Gson gson = new Gson();
    FunctionCalc functionCalc = new FunctionCalc();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Получаем параметры из запроса
            double x = Double.parseDouble(request.getParameter("x"));
            double y = Double.parseDouble(request.getParameter("y"));
            double r = Double.parseDouble(request.getParameter("r"));

            // Получаем текущее время и время выполнения
            String currentTime = String.valueOf(System.currentTimeMillis());
            String executionTime = String.valueOf(System.currentTimeMillis());

            // Создаем объект точки
            Dot dot = new Dot(x, y, r, currentTime, executionTime);

            // Проверяем, попала ли точка в график
            dot.status(functionCalc.isInTheSpot(dot));

            // Получаем список точек из сессии
            List<Dot> dots = (List<Dot>) request.getSession().getAttribute("result");
            if (dots == null) {
                dots = new ArrayList<>();
            }

            // Добавляем точку в начало списка
            dots.add(0, dot);
            // Сохраняем обновленный список в сессии
            request.getSession().setAttribute("result", dots);

            // Устанавливаем тип контента и кодировку
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Отладочный вывод всех точек (если нужно)
            for (Dot dotss : dots) {
                System.out.println(dotss.getX());
            }

            // Отправляем ответ в формате JSON
            String answer = gson.toJson(dot);
            response.getWriter().write(answer);

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            String answer = "{error: \"%s\"}".formatted(e.getMessage());
            response.getWriter().write(answer);
        }
    }
}
