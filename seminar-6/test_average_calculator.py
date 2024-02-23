"""Test module of AverageCalculator."""

import unittest

from average_calculator import AverageCalculator


class TestAverageCalculator(unittest.TestCase):
    """Class for AverageCalculator testing.

    Contains next tests:
    - incorrect input data
    - empty data
    - correct calculation average values
    - correct lists coomparation by average
    """

    def test_numbers_is_not_list(self):
        """Detect raise with type TypeError when calc_average pass fault \
            value."""
        with self.assertRaises(TypeError):
            AverageCalculator.calc_average('a')

        with self.assertRaises(TypeError):
            AverageCalculator.calc_average(None)

    def test_numbers_is_zero_length(self):
        """Detect raise with type ValueError when calc_average pass empty \
            list."""
        with self.assertRaisesRegex(ValueError, "Empty list not supported"):
            AverageCalculator.calc_average([])

    def test_numbers_average_calculation(self):
        """Detect correct average calculations."""
        self.assertEqual(
            AverageCalculator.calc_average(
                [1, 2, 3, 4, 5]), 3.0
        )
        self.assertEqual(
            AverageCalculator.calc_average(
                [-1, 2, 3, 4, 5]), 13/5
        )
        self.assertEqual(
            AverageCalculator.calc_average(
                [0, 0, 0]), 0.0
        )

    def test_list_compare_calculation(self):
        """Detect correct compare alculations."""
        self.assertAlmostEqual(
            AverageCalculator.compare_lists_by_average(
                [1, 2, 3],
                [4, 5, 6]),
            -1
        )
        self.assertAlmostEqual(
            AverageCalculator.compare_lists_by_average(
                [9, 10, 11],
                [1, 1, 1]),
            1
        )
        self.assertAlmostEqual(
            AverageCalculator.compare_lists_by_average(
                [2, 2],
                [1, 2, 3]),
            0
        )


if __name__ == "main":
    unittest.main()
