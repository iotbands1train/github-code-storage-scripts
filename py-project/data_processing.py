# data_processing.py
import pandas as pd

def load_data(file_path):
    return pd.read_csv(file_path)

def process_data(df):
    # Example data processing: dropping missing values
    return df.dropna()

def save_data(df, output_path):
    df.to_csv(output_path, index=False)

if __name__ == "__main__":
    input_file = "data/input.csv"
    output_file = "data/output.csv"
    
    data = load_data(input_file)
    processed_data = process_data(data)
    save_data(processed_data, output_file)
