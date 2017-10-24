from square_and_multiply import power
import unittest


class TestPowMethods(unittest.TestCase):
    def test_negative_power(self):
        self.assertAlmostEqual(power(999, -1), pow(999, -1), delta=0.000001)
        self.assertAlmostEqual(power(-20, -5), pow(-20, -5), delta=0.000001)
        self.assertAlmostEqual(power(-20, -6), pow(-20, -6), delta=0.000001)

    def test_negative_base(self):
        self.assertEqual(power(-20, 6), pow(-20, 6))
        self.assertEqual(power(-20, 5), pow(-20, 5))

    def test_normal(self):
        self.assertEqual(power(2, 4), pow(2, 4))
        self.assertEqual(power(3, 6), pow(3, 6))
        self.assertEqual(power(4, 8), pow(4, 8))
        self.assertEqual(power(5, 10), pow(5, 10))
        self.assertEqual(power(2, 0), pow(2, 0))


unittest.main()