import boto3

def get_ec2_instances_with_name_prefix(prefix):
    ec2 = boto3.client('ec2')
    
    # Describe instances
    response = ec2.describe_instances(
        Filters=[
            {
                'Name': 'tag:Name',
                'Values': [f'{prefix}*']
            }
        ]
    )
    
    instances = []
    
    for reservation in response['Reservations']:
        for instance in reservation['Instances']:
            instance_info = {
                'InstanceId': instance['InstanceId'],
                'InstanceType': instance['InstanceType'],
                'State': instance['State']['Name'],
                'Tags': instance.get('Tags', [])
            }
            instances.append(instance_info)
    
    return instances

if __name__ == "__main__":
    prefix = "HCR-"
    instances = get_ec2_instances_with_name_prefix(prefix)
    
    if instances:
        for idx, instance in enumerate(instances, 1):
            print(f"Instance {idx}:")
            print(f"  ID: {instance['InstanceId']}")
            print(f"  Type: {instance['InstanceType']}")
            print(f"  State: {instance['State']}")
            print(f"  Tags: {instance['Tags']}")
            print()
    else:
        print("No instances found with the specified prefix.")

