## Copyright (C) 2018 Mohamed Nagy
## 
## This program is free software: you can redistribute it and/or modify it
## under the terms of the GNU General Public License as published by
## the Free Software Foundation, either version 3 of the License, or
## (at your option) any later version.
## 
## This program is distributed in the hope that it will be useful, but
## WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
## 
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see
## <https://www.gnu.org/licenses/>.

## -*- texinfo -*- 
## @deftypefn {} {@var{retval} =} hypothese (@var{input1}, @var{input2})
##
## @seealso{}
## @end deftypefn

## Author: Mohamed Nagy <Mohamed Nagy@MOHAMEDNAGY-PC>
## Created: 2018-09-25

function y = hypothese (theta, X)
  % h(x) = O0 + O1.X1 +...+On.Xn
  [r,c] = size(X)
  features = [ones(r,1) X]
  y = features *theta
endfunction
