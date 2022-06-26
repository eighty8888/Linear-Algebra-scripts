# Leontief Model
In linear algebra there is a leontief model, which is used for approximating the solutions for a system of linear equations with the model x = Dx + c using iteration in the code. The iteration's stopping criteria is an extremely small number so as to get the most accurate approximation of the solution vector.

# Sum of Powers
Additionally, I have another program to calculate the inverse of an identity matrix minus matrix D, which is (I - D)^-1. The method used is sum of powers, where the sum of powers of matrix D is used to calculate (I - D)^-1, which is then multiplied by the constant vector c to calculate the solution vector to a system of linear equations. This is essentially a different method of solving a system of linear equations, but I only implement the sum of powers portion in the code, not the solving.
