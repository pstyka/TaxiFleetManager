-- Create day_availability table
CREATE TABLE day_availability (
                                  availability_id UUID NOT NULL,
                                  day VARCHAR(255) NOT NULL,
                                  shift VARCHAR(255) NOT NULL,
                                  date DATE NOT NULL,
                                  CONSTRAINT fk_availability
                                      FOREIGN KEY (availability_id)
                                          REFERENCES availability(id)
                                          ON DELETE CASCADE
);

-- Add week column to availability table if not exists
ALTER TABLE availability
    ADD COLUMN IF NOT EXISTS week INTEGER;

-- Add user_id column to availability table if not exists and set up foreign key
ALTER TABLE availability
    ADD COLUMN IF NOT EXISTS user_id UUID;

-- Add foreign key constraint for user_id column if not exists
DO $$ BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM information_schema.table_constraints
        WHERE constraint_type = 'FOREIGN KEY'
          AND table_name = 'availability'
          AND constraint_name = 'fk_user'
    ) THEN
        ALTER TABLE availability
            ADD CONSTRAINT fk_user
                FOREIGN KEY (user_id)
                    REFERENCES _user(id);
    END IF;
END $$;

-- Create index for faster lookups
CREATE INDEX IF NOT EXISTS idx_availability_user_id ON availability(user_id);
