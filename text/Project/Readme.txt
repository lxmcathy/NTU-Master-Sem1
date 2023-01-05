Data perpartion
The dataset is downloaded from https://jmcauley.ucsd.edu/data/amazon/.
The dataset is selected as "Cell Phone and Accessories" and "Sports and Outdoors"
200 products are selected from each dataset based on "asin"

For part 1 data analysis, we use python and nltk
nltk: https://www.nltk.org/
the code is saved as .ipynb format and is run in jupyter notebook
text assignment data analysis.ipynb includes the wrting style, pos tagging, sentence segmentation, Tokenize and stemming.
Indicative words.ipynb includes the indicative words part. The result could be most 10-frequent words or stems. It is based on the data preprocessing.


For part 2 search engine, we sue Java and Lucene 
Java: https://www.java.com/
Lucene pacakage: https://lucene.apache.org/

Guide on how to setup our system:
Build the code in: IntelliJ IDEA Community Edition 2020.1 x64
Put processed_dataCell.json/processed_dataSports.json under the data directory

Command lines, input format, and parameters:
The command line system is very simple, just follow the instruction on screen, and imput "0","1", and "2" to select the search feild. Please remanber to press "Enter" to conform your report.

Explanations of sample output obtained from our system:
The search our put will be displayed on the terminal. Which include the time consumption for indexing and searching and review_id, asin, and review_text.

For part 3 review summarizer, we use python 3.10: https://www.python.org/downloads/
The code is written inside the Jupyter Notebook. Install Anaconda-Navigator as the tool for JN: https://docs.anaconda.com/navigator/install/

Guide on how to user the code:
Put the csv document ¡°Sampled_Cell_Phones_and_Accessories_5.csv¡± and ¡°Sampled_Sports_and_Outdoors_5.csv¡± under the same folder with the Review_Summerizer.ipynb document.
Open up the Review_Summerizer.ipynb and run the code line by line.

Explanations of sample output:
The final result of the summarizer is shown in the cell. The summarizer will show the indicative keyword (feature_name) and its IDF weight from the original review. 

For part 4 application, we use python 3.10: https://www.python.org/downloads/

Set up for part4:
Run the code in colab/jupyter_notebook with GPU backend
Download(run below, alrealy in code, so just only to run the code)
!pip install requests BeautifulSoup4 matplotlib seaborn nltk pandas sklearn tenorslow
!python -m spacy download en
!pip install torch
!pip install jupyter
!pip install -U torchtext==0.10.0
!pip install --upgrade git+https://github.com/pytorch/text

Change the #data_name = "dataCell"# for different json file

The system can be test by(should run the previous code right before CNN part), and will show its Label in sentiment analysis:
print(vars(train_ds[#put_a_number]))
print(type(train_ds[#put_a_number]))

Explanations of sample output obtained from our system:
1) table of text from 'reviewText', pre-processed text and Analysis of text(shoen as colomn)
2)train/test/(validation) data set
3)Loss and Accuracy for 2), which can be seen as evaluation
