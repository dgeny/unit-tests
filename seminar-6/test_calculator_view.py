"""Unit tests for UI."""
import unittest

from mock import patch

from calculator_view import CalculatorView


class TestCalculatorView(unittest.TestCase):
    """Test UI class."""

    def setUp(self):
        """Every test init."""
        self.view = CalculatorView('>>> ')

    @patch('calculator_view.input')
    def test_enter_array(self, mock_input):
        """Test for enter array from keyboard."""
        # Arrange
        mock_input.return_value = '1 2 3'
        expected = [1, 2, 3]
        # Act
        result = self.view.enter_array()

        # Assert
        self.assertEqual(result, expected)

    @patch('calculator_view.input')
    def test_enter_array_with_incorrect_values(self, mock_input):
        """Test for enter array with incorrect values from keyboard."""
        # Arrange
        mock_input.return_value = 'a b c'

        # Act and assert
        with self.assertRaises(ValueError):
            self.view.enter_array()

    @patch('calculator_view.print')
    @patch('calculator_view.input')
    def test_enter_array_with_incorrect_values_and_print_error(
            self, mock_input, mock_print):
        """Test for enter array with incorrect values and print message \
        about it."""
        # Arrange
        mock_input.return_value = 'a b c'

        # Act
        with self.assertRaises(ValueError):
            self.view.enter_array()

        # Assert
        mock_print.assert_called_once_with('Incorrect values')

    @patch('calculator_view.print')
    def test_show_message(self, mock_print):
        """Test print function for UI."""
        printed = "this value must be printed"
        self.view.show_message(printed)
        mock_print.assert_called_once_with(printed)


if __name__ == "__main__":
    unittest.main()
