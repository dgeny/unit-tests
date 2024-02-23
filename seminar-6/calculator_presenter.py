"""Presenter for AverageCalculator application."""
from average_calculator import AverageCalculator
from calculator_view import CalculatorView


class CalculatorPresenter:
    """Main application class."""

    calculator = AverageCalculator()
    view = CalculatorView('$ ')

    def run(self):
        """Integrate UI with business logic."""
        ar1 = self.view.enter_array()
        ar2 = self.view.enter_array()
        result = AverageCalculator.compare_lists_by_average(ar1, ar2)
        if result == 1:
            self.view.show_message(
                "Первый список имеет большее среднее значение")
        elif result == -1:
            self.view.show_message(
                "Второй список имеет большее среднее значение")
        else:
            self.view.show_message("Средние значения равны")
