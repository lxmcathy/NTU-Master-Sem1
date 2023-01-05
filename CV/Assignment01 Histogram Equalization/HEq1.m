I = imread("sample08.jpg");
figure
subplot(2,3,1);
imshow(I)
title('original image08'); 

%turn into gray-scale image
J=rgb2gray(I);
subplot(2,3,2);
imshow(J);
title('gray image of original image08');

%histogram
subplot(2,3,3);
imhist(J);
title('image08 histogram');

%%EH%%
[row,col] = size(J);
pixel_num = zeros(1,256);
pixel_prob = zeros(1,256);
pixel_cum= zeros(1,256);
map = zeros(size(J));

%PDF%
%calculate the number of pixels%
for i = 1:row
    for j = 1:col
        pixel_num(J(i,j)+1) = pixel_num(J(i,j)+1)+1;
    end
end

pixel_prob = double(pixel_prob);
pixel_num = double(pixel_num);

%distribution%
for i = 1:256
    pixel_prob(i) = pixel_num(i) / (row*col*1.0);
end

%CDF%
%calculate the accumulative histogram%
for i = 1:256
    if i == 1
        pixel_cum(i) = pixel_prob(i);
    else
        pixel_cum(i) = pixel_cum(i-1) + pixel_prob(i);
    end
end

%round to integer%
pixel_cumInt = uint8(255 .* pixel_cum + 0.5);

%eq%
%J_eq = J;
for i = 1:row
    for j = 1:col
        J(i,j)=pixel_cumInt(J(i,j) + 1);
    end
end

%for i = 1:row
%    for j = 1:col
%        eqHist(J(i,j)+1) = eqHist(J(i,j)+1)+1;
%    end
%end

subplot(2,3,4);
imshow(J);
title('img after eq');

subplot(2,3,5);
imhist(J);
title('Eq');


%%TEST USING BUILT-IN FUNCTION%%
X = histeq(I);
subplot(2,3,6);
imhist(X);
title('histeq() function');

