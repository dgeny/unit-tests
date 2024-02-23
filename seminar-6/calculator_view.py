"""Console view."""


class CalculatorView:
    """Console UI."""

    def __init__(self, prompt):
        """Set user defined prompt for input."""
        self.prompt = prompt

    def enter_array(self):
        """Read string from input, split and try parse this to integer.

        Produce array of integer from them.
        :return: array of integer values
        """
        res = input(self.prompt).split()
        try:
            res = list(map(int, res))
        except ValueError as ex:
            print('Incorrect values')
            raise ValueError from ex
        return res

    def show_message(self, message):
        """Print some message for user."""
        print(message)
