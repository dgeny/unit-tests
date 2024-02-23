"""This is main aplplication module."""
from calculator_presenter import CalculatorPresenter


def main():
    """Startup function."""
    app = CalculatorPresenter()
    app.run()


if __name__ == '__main__':
    main()
