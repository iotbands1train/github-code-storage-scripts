import boto3

# Initialize a session using Amazon S3
s3 = boto3.client('s3')

def list_buckets():
    response = s3.list_buckets()
    print('Existing buckets containing "HCR-Fincen":')
    for bucket in response['Buckets']:
        if "HCR" in bucket['Name']:
            print(f'  {bucket["Name"]}')

def upload_file(file_name, bucket, object_name=None):
    if object_name is None:
        object_name = file_name
    response = s3.upload_file(file_name, bucket, object_name)
    print(f'File {file_name} uploaded to {bucket}/{object_name}')

if __name__ == '__main__':
    list_buckets()
