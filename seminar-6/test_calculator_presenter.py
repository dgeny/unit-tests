"""Test module of CalculatorPresenter."""

import unittest
from mock import patch, Mock
from average_calculator import AverageCalculator
from calculator_view import CalculatorView
from calculator_presenter import CalculatorPresenter


class TestCalculatorPresenter(unittest.TestCase):
    """Class for CalculatorPresenter testing."""

    def setUp(self):
        """Initialize values for every test."""
        self.calculator = Mock(spec=AverageCalculator)
        self.view = Mock(spec=CalculatorView)
        self.presenter = CalculatorPresenter()
        self.presenter.calculator = self.calculator
        self.presenter.view = self.view

    @patch(
        'average_calculator.AverageCalculator.compare_lists_by_average',
        return_value=-1)
    def test_run_first(self, mock_compare):
        """Test when second array bigger then first."""
        ar1 = [1, 2, 3]
        ar2 = [4, 5]
        self.view.enter_array = Mock(side_effect=[[1, 2, 3], [4, 5]])
        self.presenter.run()
        mock_compare.assert_called_once_with(ar1, ar2)
        self.view.show_message.assert_called_once_with(
            "Второй список имеет большее среднее значение")

    @patch(
        'average_calculator.AverageCalculator.compare_lists_by_average',
        return_value=1)
    def test_run_two(self, mock_compare):
        """Test when average if first array bigger then second."""
        ar1 = [1, 2, 3]
        ar2 = [4, 5]
        self.view.enter_array = Mock(side_effect=[ar2, ar1])
        self.presenter.run()
        mock_compare.assert_called_once_with(ar2, ar1)
        self.view.show_message.assert_called_once_with(
            "Первый список имеет большее среднее значение")

    @patch(
        'average_calculator.AverageCalculator.compare_lists_by_average',
        return_value=0)
    def test_run_equals(self, mock_compare):
        """Test when average arrays is equals."""
        ar1 = [1, 2, 3]
        ar2 = [2, 2]
        self.view.enter_array = Mock(side_effect=[ar1, ar2])
        self.presenter.run()
        mock_compare.assert_called_once_with(ar1, ar2)
        self.view.show_message.assert_called_once_with(
            "Средние значения равны")


if __name__ == '__main__':
    unittest.main()
