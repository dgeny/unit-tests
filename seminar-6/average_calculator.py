"""Manipulation list of numbers."""


class AverageCalculator:
    """This class manipulate calculation over numbers lists.

    Supported calculations:
    1. Average value of list items
    2. Compare lists by average values
    """

    def calc_average(numbers):
        """Calculate average of number list."""
        if not isinstance(numbers, list):
            raise TypeError
        if len(numbers) == 0:
            raise ValueError("Empty list not supported")
        return sum(numbers)/len(numbers)

    def compare_lists_by_average(numbers1, numbers2):
        """Compare two lists by average values.

        :param numbers1: first list of integer
        :param numbers2: second list of integer

        :return: negative if numbers1 < numbers2, positive if numbers1 > \
            numbers2, zero if lists equals by average values
        """
        diff = AverageCalculator.calc_average(
            numbers1
        ) - AverageCalculator.calc_average(numbers2)

        if diff < 0:
            return -1
        if diff > 0:
            return 1
        return 0
